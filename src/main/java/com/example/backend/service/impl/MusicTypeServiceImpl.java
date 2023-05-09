package com.example.backend.service.impl;

import com.example.backend.dto.MusicTypeDto;
import com.example.backend.exception.InvalidException;
import com.example.backend.exception.NotFoundException;
import com.example.backend.model.MusicType;
import com.example.backend.repository.MusicTypeRepository;
import com.example.backend.service.MusicTypeService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MusicTypeServiceImpl implements MusicTypeService {
    private MusicTypeRepository repo;

    public MusicTypeServiceImpl(MusicTypeRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<MusicType> findAll() {
        return repo.findAll();
    }

    @Override
    public MusicType getById(String id) {
        Optional<MusicType> musicType = repo.findById(id);
        return musicType.get();
    }

    @Override
    public MusicType create(MusicTypeDto dto, MultipartFile thumbnail) throws IOException {
        MusicType musicType;
        if(ObjectUtils.isEmpty(dto.getName())) {
            throw new InvalidException("Vui lòng nhập tên thể loại nhạc");
        }
        musicType = new MusicType();
        musicType.setName(dto.getName());
        musicType.setThumbnail(thumbnail.getBytes());
        repo.save(musicType);
        return musicType;
    }

    @Override
    public MusicType update(String id, MusicTypeDto dto, MultipartFile thumbnail) {
        return null;
    }

    @Override
    public MusicType delete(String id) {
        MusicType musicType = getById(id);
        if(musicType == null) {
            throw new NotFoundException(String.format("Không tìm thấy thể loại nhạc có id %s", id));
        }
        repo.delete(musicType);
        return musicType;
    }
}
