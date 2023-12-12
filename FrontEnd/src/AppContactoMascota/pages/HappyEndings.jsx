import { useContactoMascota } from "../../hooks/useContactoMascota";
import Layout from "../../ui/Layout";
import { HappyEndingCard } from "../components";

export const HappyEndings = () => {
  const { happyEndings } = useContactoMascota();

  const renderHappyEndings = () => {
    if (happyEndings.length > 0) {
      return happyEndings.map((h) => <HappyEndingCard key={h.id} data={h} />);
    }
  };

  return (
    <Layout>
      <main className="max-w-screen-xl mx-auto p-4">
        <h1 className="text-4xl font-bold text-center mb-4">Finales Felices</h1>

        <div className="grid grid-cols-2 md:grid-cols-3 gap-4 my-4">
          {renderHappyEndings()}
        </div>
      </main>
    </Layout>
  );
};
