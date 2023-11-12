package com.example.backend_login_demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// Data, NoArgsConstructor, AllArgsConstructor 는 Lombok 어노테이션

@Data   // 클래스 내 모든 필드에 대해 getter/setter, hashCode, toString, equals 등의 메서드 자동 생성
@NoArgsConstructor  // 파라미터가 없는 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 파라미터로 받는 생성자 자동 생성
@Entity // JPA 에서 엔티티 클래스임을 나타내는 어노테이션. DB에서 테이블과 매핑되는 엔티티 클래스임을 나타냄
@Table(name = "person_table")   // 해당 클래스가 매핑되는 테이블의 이름을 지정
public class Person {
    @Id // 해당 필드가 엔티티의 기본 키임을 나타내는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키의 생성 전략을 설정.
    // 이 경우 mysql 처럼 자동으로 증가하는 값을 사용하도록 설정

    private Integer number;
    private String userId;
    private String userPwd;
    private String userName;

}
