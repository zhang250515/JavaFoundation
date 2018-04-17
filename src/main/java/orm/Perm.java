package orm;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Created by ZhangQ on 2018/4/16.
 */
@Entity
public class Perm {
    private int id;
    private Integer parentId;
    private String tree;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "parentId")
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "tree")
    public String getTree() {
        return tree;
    }

    public void setTree(String tree) {
        this.tree = tree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perm perm = (Perm) o;
        return id == perm.id &&
                Objects.equals(parentId, perm.parentId) &&
                Objects.equals(tree, perm.tree);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, parentId, tree);
    }

    @Override
    public String toString() {
        return "Perm{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", tree='" + tree + '\'' +
                '}';
    }
}
