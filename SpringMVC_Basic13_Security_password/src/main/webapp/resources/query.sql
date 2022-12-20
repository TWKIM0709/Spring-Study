비밀번호 암호화

1.

Root  Context 
<bean id="bCryptPasswordEncoder"   class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder">
		
</bean>


2.
Servlet Context 
<security:password-encoder ref="bCryptPasswordEncoder"/>


3. Memeber Table 
password :     PWD        VARCHAR2(50)
암호:          PWD        VARCHAR2(2000)    
alter table member
modify (pwd varchar2(200));


4. MemberDAO 인터페이스
              //회원가입
		public int insertMember(Member member);

	      //로그인
        
     
              //회원수정
		public int updateMember(Member member);

                 
5.  @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

   생성 주입
   member.setPwd(this.bCryptPasswordEncoder.encode(member.getPwd()));

   기존 패스워드 비교
   boolean result = bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
   사용자 입력 : rawPassword >  1111
   DB 비번     : encodedPassword > $2a$10$wz7BhLkBKPV164JGmtEf4.9e9dn1ji6ABDC7cw9PxghN4o6BVaXhy


회원 : enabled >> 1 (member 테이블)
권한 : ROLE_USER (Roll 테이블)



6. 회원 가입시   ( 반드시 회원은 권한) ***************************************************
   roll 테이블에  기본 권한을 가지고 있어야 한다
   insert into roll
   values('park','ROLE_ADMIN');

참고 사이트

http://scw0531.blog.me/221002903898
https://d2.naver.com/helloworld/318732
https://blog.naver.com/cana01/220601034740
https://blog.naver.com/pyj721aa/221268168586

개념
- 평문 (Plain text)
- 암호문 (Cipher text)
- 암호화 (Encryption)
- 복호화 (Decryption)

1. MD5 (Message-Digest Algorithm) 
단방향 암호화
128비트 암호화 해시 함수 
주로 프로그램이나 파일이 원본 그대로인지를 확인하는 무결성검사 등에 사용 
해킹에 취약하므로 해시함수로 SHA 알고리즘을 권장 
임의의 길이의 입력을 받아 128비트(16비트) 고정길이 값을 출력 

2. SHA (Secure Hash Algorithm) 
단방향 암호화
SHA1, SHA2(SHA244, SHA256, SHA512) SHA256 이상 권장

3. RSA (Ron Rivest, Adi Shamir, Loenard Adleman) 
양방향 암호화
비대칭키 알고리즘 (암호화, 복호화 키가 다름)
암호화는 공개키, 복호화는 개인키 사용
SSL 적용이 어려울 경우 javascript로 RSA 사용도 가능

공개키 암호시스템의 하나로 암호화뿐만 아니라 전자서명이 가능한 최초의 알고리즘 
RSA의 전자서명 기능은 인증을 요구하는 전자상거래 등에  RSA의 광범위한 활용을 가능하게 함 
공개키 (Public Key), 개인키 (Private Key)가 존재 
원본데이터 –(공개키)–> 암호화데이터 –(유통)–> 암호화데이터 –(개인키)–> 원본데이터 

4. AES (Advanced Encryption Standard) 
양방향 암호화
대칭키 알고리즘 (암호화, 복호화 키가 동일)
2001년 미국 표준 기술 연구소 (NIST)에 의해 제정된 암호화 방식 
존 대먼과 빈센트 라이먼에 의해 개발된 Rijndael(레인달) 암호에 기반하며 AES 공모전에서 선정 
AES 표준은 여러 Rijndael 알고리즘 중 블록 크기가 128비트인 알고리즘

5. DES
보안상 취약점 발견으로 권고하지 않음

6. TDES (DES3)
DES 3중
[출처] Java 암호화 알고리즘|작성자 서정적정서