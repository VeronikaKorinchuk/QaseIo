package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SharedStep {
    String title;
    String action;
}
