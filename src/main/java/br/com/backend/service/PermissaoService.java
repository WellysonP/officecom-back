package br.com.backend.service;

import br.com.backend.exception.AlreadyExistsException;
import br.com.backend.exception.NotFoundException;
import br.com.backend.model.dto.permissao.PermissaoDTO;
import br.com.backend.model.entity.Permissao;
import br.com.backend.repository.PermissaoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class PermissaoService {

    @Inject
    PermissaoRepository permissaoRepository;

//    @Inject
//    PermissaoMapper permissaoMapper;

    public List<PermissaoDTO> list() {
        return permissaoRepository.listAll()
                .stream().sorted(Comparator.comparingLong(Permissao::getId).reversed())
                .map(permissao -> PermissaoDTO.entityToDTO(permissao)).collect(Collectors.toList());
    }

    public PermissaoDTO findById(Long id) {
        Permissao permissao = permissaoRepository.findById(id);

        if (Objects.isNull(permissao)) {
            throw new NotFoundException("Permissão não encontrado.");
        }
        return PermissaoDTO.entityToDTO(permissao);
//        return permissaoMapper.toDTO(permissao);
    }

    public PermissaoDTO create(PermissaoDTO criarPermissao) {
        Permissao permissao = new Permissao();
        permissao.setNome(criarPermissao.getNome());
        permissao.setDescricao(criarPermissao.getDescricao());

        Permissao permissaoExiste = permissaoRepository.findByNome(permissao.getNome());

        if (Objects.nonNull(permissaoExiste)) throw new AlreadyExistsException("Permissão já existe!");

        permissaoRepository.persistAndFlush(permissao);

        return PermissaoDTO.entityToDTO(permissao);
    }

    public PermissaoDTO update(PermissaoDTO atualizarPermissao, Long id) {

        Optional<Permissao> permissao = permissaoRepository.findByIdOptional(id);

        if (permissao.isEmpty()) throw new NotFoundException("Permissão não encontrado!");

        Permissao permissaoUpdated = permissao.get();
        permissaoUpdated.setNome(atualizarPermissao.getNome());
        permissaoUpdated.setDescricao(atualizarPermissao.getDescricao());
        permissaoUpdated.setGrupo(atualizarPermissao.getGrupo());
        permissaoRepository.persistAndFlush(permissaoUpdated);

        return PermissaoDTO.entityToDTO(permissaoUpdated);
    }

    public void delete(Long id) {
        Optional<Permissao> permissao = permissaoRepository.findByIdOptional(id);

        if (permissao.isEmpty()) throw new NotFoundException("Permissão não encontrado!");

        permissaoRepository.delete(permissao.get());
    }

}
