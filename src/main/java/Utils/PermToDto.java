package Utils;

import orm.Perm;
import orm.PermDto;

/**
 * Created by ZhangQ on 2018/4/16.
 */
public class PermToDto {

    private static PermDto dto;

    public static PermDto converse(Perm perm){
        dto = new PermDto();
        dto.setId(perm.getId());
        dto.setParentId(perm.getParentId());
        dto.setTree(perm.getTree());
        return dto;
    }
}
