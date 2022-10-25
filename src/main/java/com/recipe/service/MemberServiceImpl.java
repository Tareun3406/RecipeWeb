package com.recipe.service;

import com.recipe.dao.MemberDAO;
import com.recipe.vo.AuthVO;
import com.recipe.vo.MemberVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberDAO memberDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailSender mailSender;

    //회원가입
    @Transactional
    @Override
    public void insertMemberUser(MemberVO member) {
        member.setUserpw(passwordEncoder.encode(member.getUserpw()));   // 비밀번호 인코딩
        AuthVO auth = new AuthVO();                             // 권한 VO
        auth.setUserid(member.getUserid());
        auth.setAuth(AuthVO.AUTH_USER);

        memberDAO.insertMember(member);
        memberDAO.insertAuth(auth);
    }

    // 이메일로 가입된 아이디 목록
    @Override
    public List<MemberVO> findIdList(String email) {
        return memberDAO.findIdList(email);
    }

    // 아이디로 회원정보 가져오기
    @Override
    public MemberVO idCheck(String id) {
        return memberDAO.checkId(id);
    }

    // 비밀번호 변경후 이메일 보내기
    @Transactional
    @Override
    public int changePwSend(MemberVO member) {
        int result;

        SimpleMailMessage smm = new SimpleMailMessage();


        String ranPw = randomPW(10);
        member.setUserpw(passwordEncoder.encode(ranPw));
        result=memberDAO.updateFindPw(member);

        smm.setFrom("tareun3406@gmail.com");
        smm.setTo(member.getEmail());
        smm.setSubject("cookbook 비밀번호 찾기");
        smm.setText("변경된 비밀번호입니다 로그인후 변경해주세요 \n"+ranPw);

        mailSender.send(smm);

        return result;
    }





    //------------------------------------------------ 사용자 설정 메서드 -----------------------------------

    // 랜덤 문자열 생성(대소문자+숫자)
    private String randomPW(int length){
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        char addChar;
        for (int i = 0; i<length; i++){
            int rndCheck = random.nextInt(3);
            switch (rndCheck){
                case 0: // 대문자
                    addChar= (char)(random.nextInt(26)+65);
                    stringBuilder.append(addChar);
                case 1: // 소문자
                    addChar= (char)(random.nextInt(26)+97);
                    stringBuilder.append(addChar);
                    break;
                case 2: // 숫자
                    stringBuilder.append(random.nextInt(10));
                    break;
            }
        }
        return stringBuilder.toString();
    }
}
