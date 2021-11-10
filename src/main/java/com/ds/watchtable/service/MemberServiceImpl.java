package com.ds.watchtable.service;

import com.ds.watchtable.dto.MemberDTO;
import com.ds.watchtable.dto.PosDTO;
import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.Pos;
import com.ds.watchtable.entity.Review;
import com.ds.watchtable.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.ds.watchtable.entity.QMember.member;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    final private MemberRepository memberRepository;

    //db 저장
    @Override
    public String register(MemberDTO memberDTO) {
        Member member = dtoToEntity(memberDTO);
        memberRepository.save(member); //save: 저장, 수정
        return member.getMemberName();
    }
}

// ------ 삽질 샤따내립니다 -----------------------------------------------------

//    @Override
//    public MemberDTO get(Long memberNum) {
//        Optional<Member> result = memberRepository.findById(memberNum);
//        return result.isPresent() ? entityToDTO(result.get()) : null;
//    }

//    @Override
//    public List<MemberDTO> getAll() {
//        List<Member> list = memberRepository.findAll();
//        List<MemberDTO> dtoList = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            MemberDTO dto = entityToDTO(list.get(i));
//            dtoList.add(dto);
//        }
//        return dtoList;
//    }

// ------ 삽질 샤따내립니다 -----------------------------------------------------


//    @Override
//    public MemberDTO get(Long memberNum) {
//        Object result = memberRepository.findAll();
//        Object[] arr = (Object[]) result;
//        return entityToDTO((Member)arr[0]);
//    }

//    @Override
//    public User add(User user) throws Exception {
//        return userRepository.save(user);
//    }


