package com.xworkz.xworkz_module.service;

import com.xworkz.xworkz_module.dto.CommonModuleDTO;
import com.xworkz.xworkz_module.entity.AbstractAdutEntity;
import com.xworkz.xworkz_module.entity.CommonModuleEntity;
import com.xworkz.xworkz_module.repositroy.CommonModuleRepository;
import org.hibernate.tool.schema.spi.ScriptTargetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.Set;

@Service
public class CommonModuleServiceImpl implements CommonModuleService {

    @Autowired
    CommonModuleRepository commonModuleRepository;

    String generatedPassword;


    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    CommonModuleEntity commonModuleEntity = new CommonModuleEntity();

    private final static String character = "ABCDEFGHIJKLMNOPQRSTQUVWXYZabcdefghijkmloppqrstuvxxyz09876554321@";

    public CommonModuleServiceImpl() {
        System.out.println("Created CommonModuleServiceImpl");
    }

    @Override
    public Set<ConstraintViolation<CommonModuleDTO>> validateAndSave(CommonModuleDTO commonModuleDTO) {

        boolean isValid = false;

        if (commonModuleDTO != null) {
            if (commonModuleDTO.getName() != null) {
                commonModuleEntity.setName(commonModuleDTO.getName());
                isValid = true;
            }

            if (commonModuleDTO.getEmail() != null) {
                commonModuleEntity.setEmail(commonModuleDTO.getEmail());
                isValid = true;
            }

            if (commonModuleDTO.getPh() != null) {
                commonModuleEntity.setPh(commonModuleDTO.getPh());
                isValid = true;
            }

            if (commonModuleDTO.getAlterEmail() != null) {
                commonModuleEntity.setAlterEmail(commonModuleDTO.getAlterEmail());
                isValid = true;
            }
            if (commonModuleDTO.getAlterPh() != null) {
                commonModuleEntity.setAlterPh((commonModuleDTO.getAlterPh()));
                isValid = true;
            }

            if (commonModuleDTO.getLocation() != null) {
                commonModuleEntity.setLocation(commonModuleDTO.getLocation());
                isValid = true;
            }

            if (commonModuleDTO.getEmail() != null) {
                StringBuilder stringBuilder = new StringBuilder();
                SecureRandom secureRandom = new SecureRandom();
                for (int i = 0; i < 9; i++) {
                    int index = secureRandom.nextInt(character.length());
                    stringBuilder = stringBuilder.append(character.charAt(index));
                }
               generatedPassword =stringBuilder.toString();
                commonModuleEntity.setPassword(generatedPassword);
                isValid = true;
            }
            AbstractAdutEntity abstractAdutEntity = new AbstractAdutEntity();
            commonModuleEntity.setCreatedBy(commonModuleDTO.getName());
            abstractAdutEntity.getCreatedDate();

            commonModuleEntity.setSigninCount(-1);

            ValidatorFactory valid = Validation.buildDefaultValidatorFactory();

            Validator validator = valid.getValidator();
            Set<ConstraintViolation<CommonModuleDTO>> constraintViolations = validator.validate(commonModuleDTO);

            if (constraintViolations.isEmpty()){
                commonModuleRepository.save(commonModuleEntity);
            }else {
                System.out.println("----");
                return constraintViolations;
            }

        }
        return null;

    }

    @Override
    public Long getCountofName(String name) {
        return commonModuleRepository.getCountOfName(name);
    }

    @Override
    public Long getCountofEmail(String email) {
        return commonModuleRepository.getCountOfEmail(email);
    }

    @Override
    public Long getCountofPhone(String phone) {
        return commonModuleRepository.getCountOfPhone(phone);
    }

    @Override
    public Long getCountofAlterEmail(String alterEmail) {
        return commonModuleRepository.getCountOfAlterEmail(alterEmail);
    }

    @Override
    public Long getCountofAlterPhone(String alterPhone) {
        return commonModuleRepository.getCountOfAlterPhone(alterPhone);
    }

    @Override
    public CommonModuleEntity onSignin(String email, String password) {
    int count;
        CommonModuleEntity commonModuleEntity = commonModuleRepository.onSignin(email);
        System.out.println("getting data from repo..."+commonModuleEntity);
       int countValue= commonModuleRepository.getCount(email);
        System.out.println("count signvalue in service : "+commonModuleEntity.getSigninCount());
        System.out.println("This is a service : "+commonModuleEntity);
       if(commonModuleEntity!=null && !password.equals(commonModuleEntity.getPassword()) && email.equals(commonModuleEntity.getEmail()) &&commonModuleEntity.getSigninCount()>=0){
           System.out.println(commonModuleEntity.getSigninCount()+1);
           boolean update=commonModuleRepository.updateCount(commonModuleEntity.getSigninCount()+1,email);
           System.out.println(commonModuleEntity.getSigninCount()+1);
       }
       commonModuleEntity.setSigninCount(commonModuleEntity.getSigninCount()+1);
       commonModuleRepository.onUpdate(commonModuleEntity);
    return commonModuleEntity;
    }

    @Override
    public boolean onUpdate(String email, String newPassword, String confirmPassword) {
        if (newPassword.equals(confirmPassword)) {
            CommonModuleEntity commonModuleEntity1 = commonModuleRepository.getData(email);
            if (commonModuleEntity1 != null) {
                commonModuleEntity.setPassword(bCryptPasswordEncoder.encode(confirmPassword));
                commonModuleEntity.setSigninCount(0);
                return commonModuleRepository.onUpdate(commonModuleEntity);
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean saveEmail(String email) {

        final String username = "danb44409@gmail.com";
        final String userPassword = "qqgz izli mbtv zbia";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, userPassword);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("Your password");
            message.setText("your passwordd" +generatedPassword );

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return true;
    }

}





