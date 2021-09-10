package com.example.sacco.members;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "next_of_kin_name")
        ),
        @AttributeOverride(
                name = "phoneNumber",
                column = @Column(name = "next_of_kin_mobile")
        ),
        @AttributeOverride(
                name = "relationship",
                column = @Column(name = "relationship")
        )
})
public class NextOfKin {
    @NotEmpty(message = "next of kin name is required")
    private String name;
    private String phoneNumber;
    private String relationship;
}
