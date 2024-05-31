package fr.ycaby.repaircafe.infrastrucure.secondary.db.mapper;

public interface GenericSecondaryMapper<D, E> {
    E toEntity(D domain);
    D toDomain(E entity);
}
