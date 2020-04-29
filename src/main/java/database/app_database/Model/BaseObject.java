package database.app_database.Model;

import database.app_database.Dto.BaseDto.HasId;

import javax.persistence.MappedSuperclass;
import javax.persistence.PreRemove;
import javax.persistence.Transient;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseObject implements HasId, Serializable {

    @Transient
    protected boolean toBeRemoved;

    @PreRemove
    protected void preRemove() {
        toBeRemoved = true;
    }

    @Override
    public int hashCode() {
        if (getId() != null) {
            return getId().hashCode();
        }

        return super.hashCode();
    }

    @Override
    public boolean equals(final Object object2) {
        Object object1 = this;

        // If references are equals
        if (object1 == object2) {
            return true;
        }

        // If object2 is null (object1 can't be null)
        if (object2 == null) {
            return false;
        }

        if (object2 instanceof BaseObject) {
            if (getId() == null) {
                return false;
            } else {
                return (object1.getClass().isAssignableFrom(object2.getClass()) || object2.getClass().isAssignableFrom(
                        object1.getClass()))
                       && getId().equals(((BaseObject) object2).getId());
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + getId() + "] instance: " + super.hashCode();
    }

}
