package fr.ycaby.repaircafe.infrastrucure.primary.rest.mapper;

public interface GenericPrimaryMapper<D,E> {
    E toDto(D domain);
    D toDomain(E dto);
}
