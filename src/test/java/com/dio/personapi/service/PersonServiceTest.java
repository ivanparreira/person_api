package com.dio.personapi.service;

import com.dio.personapi.dto.request.PersonDTO;
import com.dio.personapi.dto.response.MessageResponseDTO;
import com.dio.personapi.entity.Person;
import com.dio.personapi.repository.PersonRepository;
import com.dio.personapi.utils.PersonUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.dio.personapi.utils.PersonUtils.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThemReturnSameMessege(){
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = MessageResponseDTO
                .builder()
                .message("Pessoa criada com ID " + expectedSavedPerson.getId())
                .build();
        MessageResponseDTO succesMessage = personService.createPerson(personDTO);

        Assertions.assertEquals(expectedSuccessMessage, succesMessage);
    }



}
