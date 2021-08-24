package com.joyonta.spring.data.jpa.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardinaName")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardinaEmail")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardinaMobile")
        )
}

)
public class Guardian {
    private String name;
    private String email;
    private String mobile;
}
