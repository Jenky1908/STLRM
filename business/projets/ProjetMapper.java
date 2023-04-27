package dwn.slrm.business.projets;

import dwn.slrm.generic.mappers.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueMappingStrategy;


@Mapper
public interface ProjetMapper extends GenericMapper<Projet, ProjetDto> {
}
