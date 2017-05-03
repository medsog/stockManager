export class reglementFacture.model.ts {
  constructor(
    public id: number,
    public id_facture: number,
    public id_reglement: number,
	public montant: number,
	public date_imputation: string
  ) {  }
}