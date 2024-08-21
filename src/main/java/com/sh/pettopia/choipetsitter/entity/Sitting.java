package com.sh.pettopia.choipetsitter.entity;

import com.sh.pettopia.choipetsitter.dto.ReservationDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Entity(name = "sitting")
@Table(name = "tbl_sitting")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Sitting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "service_date")
    private String  serviceDate; // 실제 요청 서비스를 실행하는 날짜

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt; // 예약을 수락한 날짜

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt; // 상태값이 바뀔때 저장

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private SittingStatus sittingStatus; // 돌봄대기, 돌봄중, 돌봄완료

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "petsitter_id")
    private String petSitterId;

    @Column(name = "request_Date")
    private LocalDateTime requestDate; // 요청이 들어온 날짜

    @Column(name = "start_time")
    private LocalTime startTime; // 예약 시작시간

    @Column(name = "end_time")
    private LocalTime endTime; // 예약 종료시간

    @Column(name = "partner_order_id")
    private String partnerOrderId; // 주문 번호

    @Column(name = "petsize_and_howmany")
    @ElementCollection
    private List<PetSizeAndHowManyPet> petSizeAndHowManyPets; // 어떤 견종을 몇마리 할 것인지

    public void changeSittingStatus(SittingStatus sittingStatus)
    {
        this.sittingStatus=sittingStatus;
    }

    public Sitting dtoToEntity(ReservationDto dto)
    {
        return Sitting.builder()
                .serviceDate(dto.getReservationDay())
                .createdAt(LocalDateTime.now())
                .sittingStatus(SittingStatus.StandbySitting)
                .petSizeAndHowManyPets(dto.getPetSizeAndHowManyPets())
                .memberId(dto.getMemberId())
                .petSitterId(dto.getPetSitterId())
                .requestDate(dto.getCreatedAt())
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .partnerOrderId(dto.getPartnerOrderId())
                .build();
    }


}
