package ucsal.medico.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "exame")
@EntityListeners(AuditingEntityListener.class)
public class Exame implements Serializable {
    /**
     * Ícaro Santana
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false, updatable = false)
    private Long codigo;

    @Column(name = "risco_ocupacional", nullable = false)
    private String riscoOcupacional;

    @Column(name = "tipo_exame_codigo", nullable = false)
    private Long tipoExameCodigo;

    @Column(name = "paciente_codigo", nullable = false)
    private Long pacienteCodigo;

    @Column(name = "medico_codigo", nullable = false)
    private Long medicoCodigo;

    public Exame() {}

    public Exame(Exame request) {
        this.riscoOcupacional = request.riscoOcupacional;
        this.tipoExameCodigo = request.tipoExameCodigo;
        this.pacienteCodigo = request.pacienteCodigo;
        this.medicoCodigo = request.medicoCodigo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getRiscoOcupacional() {
        return riscoOcupacional;
    }

    public void setRiscoOcupacional(String riscoOcupacional) {
        this.riscoOcupacional = riscoOcupacional;
    }

    public Long getTipoExameCodigo() {
        return tipoExameCodigo;
    }

    public void setTipoExameCodigo(Long tipoExameCodigo) {
        this.tipoExameCodigo = tipoExameCodigo;
    }

    public Long getPacienteCodigo() {
        return pacienteCodigo;
    }

    public void setPacienteCodigo(Long pacienteCodigo) {
        this.pacienteCodigo = pacienteCodigo;
    }

    public Long getMedicoCodigo() {
        return medicoCodigo;
    }

    public void setMedicoCodigo(Long medicoCodigo) {
        this.medicoCodigo = medicoCodigo;
    }
}