package dojo.gwt.client.screen.add;

import java.util.Set;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;

public interface AddView extends IsWidget {

	public interface Presenter {

		/** Comportement déclenché lors d'un clic sur le bouton de sauvegarde. */
		void onSaveButtonClicked();

		/** Récupère les pays disponibles. */
		Set<String> getAvailableCountries();

		/** Récupère les notes disponibles. */
		Set<Double> getAvailableGrades();

	}

	/** Attache un nouveau {@link Presenter} sur la {@link AddView}. */
	void bindOnPresenter(Presenter presenter);

	HasValue<String> getLabel();

	HasValue<String> getDescription();

	HasValue<Double> getGrade();

	HasValue<Double> getAlcohol();

	HasValue<String> getBrewery();

	HasValue<String> getCountry();

}
