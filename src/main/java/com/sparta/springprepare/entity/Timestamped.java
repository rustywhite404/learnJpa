package com.sparta.springprepare.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass //자바의 상속과 같은 개념. Timestamped를 상속하는 모든 클래스는 createdAt, modifiedAt를 가지게 된다
@EntityListeners(AuditingEntityListener.class) //엔티티의 생성, 수정 시점에 자동으로 값을 업데이트 하도록 리스너를 등록(Auditing) 해줌
public abstract class Timestamped {

    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime modifiedAt;
}