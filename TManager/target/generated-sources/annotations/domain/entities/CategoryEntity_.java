package domain.entities;

import domain.entities.TicketEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-15T12:46:21")
@StaticMetamodel(CategoryEntity.class)
public class CategoryEntity_ { 

    public static volatile SingularAttribute<CategoryEntity, Long> id;
    public static volatile SingularAttribute<CategoryEntity, String> name;
    public static volatile CollectionAttribute<CategoryEntity, TicketEntity> ticketsById;

}