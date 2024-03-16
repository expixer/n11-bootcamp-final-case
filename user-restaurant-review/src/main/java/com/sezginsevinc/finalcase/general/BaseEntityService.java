package com.sezginsevinc.finalcase.general;

import com.sezginsevinc.finalcase.error.GeneralErrorMessage;
import com.sezginsevinc.finalcase.error.exceptions.ItemNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;


@Getter
public abstract class BaseEntityService<E extends BaseEntity, R extends JpaRepository<E, Long>> {

  private final R repository;

  protected BaseEntityService(R repository) {
    this.repository = repository;
  }

  public E save(E entity) {

    BaseAdditionalFields baseAdditionalFields = entity.getBaseAdditionalFields();
    if (baseAdditionalFields == null) {
      baseAdditionalFields = new BaseAdditionalFields();
    }

    LocalDateTime now = LocalDateTime.now();
    if (entity.getId() == null) {
      // yeni kayıt
      baseAdditionalFields.setCreatedAt(now);
      //entity.getBaseAdditionalFields().setCreatorId();
    }

    baseAdditionalFields.setUpdatedAt(now);
    //entity.getBaseAdditionalFields().setUpdaterId();
    entity.setBaseAdditionalFields(baseAdditionalFields);

    entity = repository.save(entity);
    return entity;
  }

  public List<E> findAll() {
    return repository.findAll();
  }

  public E findByIdWithControl(Long id) {
    Optional<E> optionalE = repository.findById(id);
    E entity;
    if (optionalE.isPresent()) {
      entity = optionalE.get();
    } else {
      throw new ItemNotFoundException(GeneralErrorMessage.ITEM_NOT_FOUND);
      //throw new ItemNotFoundException("Data bulunamadı!");
    }

    return entity;
  }

  public Optional<E> findById(Long id){
    return repository.findById(id);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }

  public void delete(E entity){
    repository.delete(entity);
  }

  public boolean existById(Long id){
    return repository.existsById(id);
  }

}
