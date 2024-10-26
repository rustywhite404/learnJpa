package com.sparta.springprepare.service;

import com.sparta.springprepare.dto.MemoRequestDto;
import com.sparta.springprepare.dto.MemoResponseDto;
import com.sparta.springprepare.entity.Memo;
import com.sparta.springprepare.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;

    public MemoResponseDto createMemo(MemoRequestDto requestDto){
        //RequestDto -> Entity
        Memo memo = new Memo(requestDto);
        //DB 저장
        Memo saveMemo = memoRepository.save(memo);
        //Entity -> ResponseDto
        MemoResponseDto responseDto = new MemoResponseDto(memo);
        return responseDto;
    }

    @Transactional(readOnly=true)
    public List<MemoResponseDto> getMemos(){
        //DB조회
        return memoRepository.findAll().stream().map(MemoResponseDto::new).toList();
    }

    @Transactional
    public Long updateMemo(Long id, MemoRequestDto requestDto){
        //해당 메모가 DB에 존재하는지 확인
        Memo memo = findMemo(id);
        //존재하면 수정
        memo.update(requestDto);
        return id;
    }

    public Long deleteMemo(Long id){
        //해당 메모가 DB에 존재하는지 확인
        Memo memo = findMemo(id);
        memoRepository.delete(memo);
        return id;
    }

    //여러번 사용될 메서드이므로 따로 빼서 관리
    private Memo findMemo(Long id){
        return memoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("선택한 메모는 존재하지 않습니다."));
    }
}
