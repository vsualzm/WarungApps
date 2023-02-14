package barrans.devel.api.api.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class ProductUnitDTO {
    @Schema(required = true, example = "kilogram")
    public String description;
}
