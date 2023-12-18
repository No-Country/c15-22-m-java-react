import { useParams } from "react-router-dom";
import Layout from "../../ui/Layout";
import { useEffect } from "react";
import { useContactoMascota } from "../../hooks/useContactoMascota";
import { ShowPetById } from "../components/ShowPetById";

export const PetPage = () => {
  const { id } = useParams();
  const { getPet, petPage } = useContactoMascota();

  useEffect(() => {
    getPet(+id);
  }, [id]);

  const renderPet = () => {
    if (Object.values(petPage).length > 0) {
      return <ShowPetById pet={petPage} />;
    }
  };

  return (
    <Layout>
      <main className="bg-orange-100">{renderPet()}</main>
    </Layout>
  );
};
