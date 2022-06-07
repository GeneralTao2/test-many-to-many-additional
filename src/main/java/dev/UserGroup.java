package dev;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USERS_GROUPS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserGroup {
    @Id
    @GeneratedValue
    @Column(name = "USER_GROUP_ID")
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    private boolean activated;

    @Column(name = "REGISTERED_DATE")
    @Temporal(TemporalType.DATE)
    private Date registeredDate;

}