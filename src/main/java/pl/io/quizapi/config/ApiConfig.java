package pl.io.quizapi.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.io.quizapi.dao.dtos.AnswerDTO;
import pl.io.quizapi.dao.dtos.QuestionDTO;
import pl.io.quizapi.dao.entities.Answer;
import pl.io.quizapi.dao.entities.Question;

@Configuration
public class ApiConfig {
    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Answer, AnswerDTO>() {
            @Override
            protected void configure() {
                map().setAnswer(source.getAnswerText());
                map().setResult(source.getResult());
                map().setUid(source.getId().intValue());
            }
        });

        modelMapper.addMappings(new PropertyMap<Question, QuestionDTO>() {
            @Override
            protected void configure() {

                map().setQuestion(source.getQuestionText());
                map().setUid(source.getId().intValue());
            }
        });


        return modelMapper;
    }


}
