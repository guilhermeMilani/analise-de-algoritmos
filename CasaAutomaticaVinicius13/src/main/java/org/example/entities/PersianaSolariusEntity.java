package org.example.entities;

import br.furb.analise.algoritmos.PersianaSolarius;
import org.example.interfaces.PersianaInterface;

public class PersianaSolariusEntity implements PersianaInterface {
    private PersianaSolarius persianaSolarius;
    @Override
    public void abrir() throws Exception {
        if (!persianaSolarius.estaAberta())
            persianaSolarius.subirPersiana();
    }

    @Override
    public void fechar() throws Exception {
        if (persianaSolarius.estaAberta())
            persianaSolarius.descerPersiana();
    }
}
