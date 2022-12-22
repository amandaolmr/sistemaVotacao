package br.com.sistemaVotacao;

import br.com.sistemaVotacao.model.dto.PautaDto;
import br.com.sistemaVotacao.model.entity.Pauta;
import br.com.sistemaVotacao.model.mapper.PautaMapper;
import br.com.sistemaVotacao.repository.PautaRepository;
import br.com.sistemaVotacao.service.PautaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PautaServiceImplTest {

    @InjectMocks
    private PautaServiceImpl pautaService;
    @Mock
    private PautaRepository pautaRepository;
    @Mock
    private PautaMapper pautaMapper;


    @Test
    public void criarPautaTest(){

        PautaDto pautaDto = new PautaDto();
        pautaDto.setDescricao("teste");
        pautaDto.setTitulo("testeTitulo");

        Pauta pauta = new Pauta();
        pauta.setIdPauta(123L);;
        pauta.setDescricao("teste");
        pauta.setTitulo("testeTitulo");

        Mockito.when(pautaMapper.toPauta(pautaDto)).thenReturn(pauta);
        Mockito.when(pautaMapper.toPautaDto(pauta)).thenReturn(pautaDto);
        Mockito.when(pautaRepository.save(pauta)).thenReturn(pauta);

        pautaService.criaPauta(pautaDto);

        //Verifica o mock, verifica quantidade de chamadas do metódo salvar e o metodo
        Mockito.verify(pautaRepository, Mockito.times(1)).save(pauta);

    }
}
