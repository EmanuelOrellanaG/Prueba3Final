        package com.example.membresia.dto;

        import jakarta.validation.constraints.Min;
        import jakarta.validation.constraints.NotBlank;
        import jakarta.validation.constraints.NotNull;
        import jakarta.validation.constraints.Positive;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor

        public class MembresiaDTO {

                @NotNull
                private Long userId;

                @NotBlank
                private String nombre;

                private String descripcion;

                @NotNull
                @Positive
                private Double precio;

                @NotNull
                @Min(1)
                private Integer duracionDias;

                @NotNull
                private Boolean activa;
            }

