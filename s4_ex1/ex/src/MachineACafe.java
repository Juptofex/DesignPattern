import java.awt.*;

public class MachineACafe {
	private int montantEnCours;
	private ToucheBoisson boisson;
	private State state;
	public enum State {
		INACTIVE {
			@Override
			public void chooseDrink(MachineACafe m, ToucheBoisson t) {
				m.afficherPasAssez(t);
			}

			@Override
			public void giveMoneyBack(MachineACafe m) {
				m.setState(State.INACTIVE);
			}

		}, COLLECTING {
			@Override
			public void chooseDrink(MachineACafe m, ToucheBoisson t) {
				if (t.getPrix() > m.montantEnCours) {
					m.boisson = t;
					m.afficherPasAssez(m.boisson);
					m.setState(State.NOT_ENOUGH);
					return;
				}
				m.montantEnCours -= t.getPrix();
				m.afficherBoisson(t);
				m.afficherMontant();
				if (m.montantEnCours == 0)
					m.setState(State.INACTIVE);
				else
					m.setState(State.COLLECTING);
			}

		}, NOT_ENOUGH {
			@Override
			public void pay(MachineACafe m, Piece piece) {
				m.montantEnCours += piece.getValeur();
				m.afficherMontant();
				if (m.boisson.getPrix() > m.montantEnCours) {
					m.afficherPasAssez(m.boisson);
				} else {
					m.montantEnCours -= m.boisson.getPrix();
					m.afficherBoisson(m.boisson);
					m.boisson = null;
					m.afficherMontant();
					if (m.montantEnCours == 0)
						m.setState(State.INACTIVE);
					else
						m.setState(State.COLLECTING);
				}
			}

			@Override
			public void chooseDrink(MachineACafe m, ToucheBoisson t) {
				throw new IllegalStateException();
			}

		};

		public void pay(MachineACafe m, Piece piece) {
			m.montantEnCours += piece.getValeur();
			m.afficherMontant();
			m.setState(State.COLLECTING);
		}

		public abstract void chooseDrink(MachineACafe m, ToucheBoisson t);

		public void giveMoneyBack(MachineACafe m) {
			m.afficherRetour();
			m.montantEnCours = 0;
			m.boisson = null;
			m.setState(State.INACTIVE);
		}
	}

	public MachineACafe() {
		this.setState(State.INACTIVE);
		this.montantEnCours = 0;
		this.boisson = null;
	}
	
	public void afficherMontant() {
		System.out.println(montantEnCours + " cents disponibles");
	}
	
	public void afficherRetour() {
		System.out.println(montantEnCours + " cents rendus");
	}
	
	public void afficherPasAssez(ToucheBoisson toucheBoisson) {
		System.out.println("Vous n'avez pas introduit un montant suffisant pour un " + toucheBoisson);
		System.out.println("Il manque encore " + (toucheBoisson.getPrix() - montantEnCours) + " cents");
	}

	public void afficherBoisson(ToucheBoisson toucheBoisson) {
		System.out.println("Voici un " + toucheBoisson);
		
	}

	public void entrerMonnaie(Piece piece) {
		state.pay(this, piece);
	}
	
	public void selectionnerBoisson(ToucheBoisson toucheBoisson) {
		state.chooseDrink(this, toucheBoisson);
	}
	
	public void rendreMonnaie() {
		state.giveMoneyBack(this);
	}

	public void setState(State state) {
		this.state = state;
	}
}
