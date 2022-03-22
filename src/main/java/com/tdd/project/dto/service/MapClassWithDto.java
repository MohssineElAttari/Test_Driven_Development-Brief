package com.tdd.project.dto.service;

import javax.swing.text.html.parser.Entity;
import java.util.Collection;
import java.util.List;

public interface MapClassWithDto<ENTITYConvert,DTOConvert> {

    DTOConvert convertToDto(ENTITYConvert entityConvert, Class<DTOConvert> dtoClass);
    ENTITYConvert ONVERT_ENTITY(DTOConvert dtoConvert,Class<ENTITYConvert>convertClass);

    List<DTOConvert> convertListToListDto(Collection<ENTITYConvert> entityList, Class<DTOConvert> outCLass);
    List<ENTITYConvert> convertListToListEntity(Collection<DTOConvert> dtoList, Class<ENTITYConvert> outCLass);

}
