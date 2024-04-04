package co.istad.mobilebankingcstad.mapper;


import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface AccountMapper
{

}
