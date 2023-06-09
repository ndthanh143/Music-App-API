package com.example.backend.service.impl;

import com.example.backend.dto.UserDTO;
import com.example.backend.exception.InvalidException;
import com.example.backend.exception.NotFoundException;
//import com.example.backend.model.Role;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.UserService;
import com.example.backend.utils.ERole;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){this.userRepository=userRepository;}
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getTaiKhoan(String id) {
        return userRepository.findById(id).orElseThrow(()->new NotFoundException(String.format("Tài khoản có mã id là %s đã tồn tại",id)));
    }

    @Override
    public User create(UserDTO DTO) {

        if(ObjectUtils.isEmpty(DTO.getName())){
            throw new InvalidException("Tên tài khoản không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(DTO.getEmail())){
            throw new InvalidException("Địa chỉ email không được bỏ trống");

        }
        if(ObjectUtils.isEmpty(DTO.getPassword())){
            throw new InvalidException("Mật khẩu không được để trống");
        }
        if(ObjectUtils.isEmpty(DTO.getPhone())){
            throw new InvalidException("Số điện thoại không đươc bỏ trống");
        }
        if(ObjectUtils.isEmpty(DTO.getRoles())){
            throw new InvalidException("Role không được bỏ trống");

        }
        if(userRepository.kiemtraEmail(DTO.getEmail().trim())){
            throw new InvalidException(String.format("Địa chỉ email: %s đã tồn tại",DTO.getEmail()));
        }
        User taiKhoan = new User();
        taiKhoan.setName(DTO.getName().trim());
        taiKhoan.setEmail(DTO.getEmail().trim());
        taiKhoan.setPassword(DTO.getPassword());
        taiKhoan.setPhone(DTO.getPhone().trim());
        taiKhoan.setRoles(DTO.getRoles());
        userRepository.save(taiKhoan);
        return taiKhoan;
    }

    @Override
    public User update(String id, UserDTO DTO) {
        User user = getTaiKhoan(id);
        if(ObjectUtils.isEmpty(DTO.getName())){
            throw new InvalidException("Tên tài khoản không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(DTO.getEmail())){
            throw new InvalidException("Địa chỉ email không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(DTO.getPassword())){
            throw new InvalidException("Mật khẩu không được để trống");

        }
        if(ObjectUtils.isEmpty(DTO.getPhone())){
            throw new InvalidException("Số điện thoại không đươc bỏ trống");

        }
        if(ObjectUtils.isEmpty(DTO.getRoles())){
            throw new InvalidException("Role không được bỏ trống");
        }
        if(!user.getEmail().equalsIgnoreCase(DTO.getEmail().trim()) && userRepository.kiemtraEmail(DTO.getEmail().trim())){
            throw new InvalidException(String.format("Địa chỉ email: %s đã tồn tại",DTO.getEmail()));
        }
        user.setName(DTO.getName().trim());
        user.setEmail(DTO.getEmail().trim());
        user.setPassword(DTO.getPassword());
        user.setPhone(DTO.getPhone().trim());
        user.setRoles(DTO.getRoles());
        userRepository.save(user);
        return user;
    }

    @Override
    public User delete(String id) {
        User user = getTaiKhoan(id);
        userRepository.delete(user);
        return null;
    }
}
