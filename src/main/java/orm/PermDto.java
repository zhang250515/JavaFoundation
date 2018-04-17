package orm;

import java.util.List;

/**
 * Created by ZhangQ on 2018/4/16.
 */
public class PermDto {
    private int id;
    private Integer parentId;
    private String tree;
    private List<PermDto> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getTree() {
        return tree;
    }

    public void setTree(String tree) {
        this.tree = tree;
    }

    public List<PermDto> getChildren() {
        return children;
    }

    public void setChildren(List<PermDto> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "PermDto{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", tree='" + tree + '\'' +
                ", children=" + children +
                '}';
    }
}
