package viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContadorViewModel extends ViewModel {
    //MutableLiveData: lo mismo que livedata pero el valor de los datos almacenados se puede modificar
    //final hace que no se pueda cambiar la referencia, siempre se apuntara al mismo MutableLiveData
    private final MutableLiveData<Integer> contador = new MutableLiveData<>(0);
    // LiveData : clase que almacena datos observables y conscientes del ciclo de vida
    public LiveData<Integer> getContador() {
        return contador;
    }

    public void incrementarContador() {
        Integer valorActual = contador.getValue();
        if (valorActual != null) {
            contador.setValue(valorActual + 1);
        }
    }
}
