package noroff.assignment.moviecharactersapi.mappers;

import noroff.assignment.moviecharactersapi.models.Franchise;
import noroff.assignment.moviecharactersapi.models.dtos.FranchiseDTO;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface FranchiseMapper {
    FranchiseDTO franchiseToFranchiseDto(Franchise franchise);
    Collection<FranchiseDTO> franchiseToFranchiseDto(Collection<Franchise> franchises);
    Franchise franchiseDtoToFranchise(FranchiseDTO franchiseDTO);
}
