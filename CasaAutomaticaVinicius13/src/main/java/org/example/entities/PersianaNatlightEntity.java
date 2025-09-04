package org.example.entities;

import br.furb.analise.algoritmos.PersianaNatLight;
import br.furb.analise.algoritmos.PersianaSolarius;
import org.example.interfaces.PersianaInterface;

public class PersianaNatlightEntity implements PersianaInterface {
    private PersianaNatLight persianaNatLights;


    public PersianaNatlightEntity(PersianaNatLight persianaNatLights, PersianaSolarius persianaSolarius) {
        this.persianaNatLights = persianaNatLights;
    }

    @Override
    public void abrir() throws Exception {
        if (!persianaNatLights.estaPalhetaAberta() && !persianaNatLights.estaPalhetaErguida()) {
            persianaNatLights.abrirPalheta();
            persianaNatLights.subirPalheta();
        }

    }

    @Override
    public void fechar() throws Exception {
        if (persianaNatLights.estaPalhetaAberta() && persianaNatLights.estaPalhetaErguida()) {
            persianaNatLights.descerPalheta();
            persianaNatLights.fecharPalheta();
        }
    }
}
