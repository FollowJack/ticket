package domain.entities;

import domain.entities.CategoryEntity;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-15T12:46:21")
@StaticMetamodel(TicketEntity.class)
public class TicketEntity_ { 

    public static volatile SingularAttribute<TicketEntity, Long> id;
    public static volatile SingularAttribute<TicketEntity, Date> modified_on;
    public static volatile SingularAttribute<TicketEntity, String> body;
    public static volatile SingularAttribute<TicketEntity, CategoryEntity> category;
    public static volatile SingularAttribute<TicketEntity, String> subject;
    public static volatile SingularAttribute<TicketEntity, Date> created_on;
    public static volatile SingularAttribute<TicketEntity, String> owner;

}