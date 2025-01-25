CREATE OR REPLACE FUNCTION calculer_total_et_commission()
RETURNS TRIGGER AS $$
DECLARE
total_vente NUMERIC(10, 2);
    seuil_minimum NUMERIC(10, 2);
    taux_commission NUMERIC(10, 2);
    commission NUMERIC(10, 2);
BEGIN
    -- Récupérer les paramètres globaux
SELECT valeur INTO seuil_minimum FROM parametre WHERE cle = 'seuil_minimum';
SELECT valeur INTO taux_commission FROM parametre WHERE cle = 'taux_commission';

-- Calculer le total des ventes pour cette vente
SELECT SUM(quantite * prix_unitaire)
INTO total_vente
FROM vente_detail
WHERE id_vente = NEW.vente_id;

-- Calculer la commission
IF total_vente >= seuil_minimum THEN
        commission := total_vente * taux_commission;
ELSE
        commission := 0;
END IF;

    -- Mettre à jour la table `ventes`
UPDATE vente
SET montant_total = total_vente,
    commission = commission
WHERE id = NEW.vente_id;

RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE TRIGGER trigger_calculer_total_et_commission
    AFTER INSERT OR UPDATE OR DELETE
    ON vente_detail
    FOR EACH ROW
EXECUTE FUNCTION calculer_total_et_commission();
