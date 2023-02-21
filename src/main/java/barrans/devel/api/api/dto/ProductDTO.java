package barrans.devel.api.api.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class ProductDTO {
    @Schema(required = true, example = "54656568777")
    public Long barcode;

    @Schema(required = true, example = "contoh Nama product")
    public String productName;

    @Schema(required = true, example = "product terbaru")
    public String description;

    @Schema(required = true, example = "12000.00")
    public Double price;

    @Schema(required = true, example = "pgctfdyyfugtdrdfhcvgh")
    public String image;


}
