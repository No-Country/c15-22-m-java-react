import Layout from "../../ui/Layout";
import Banner from "../components/Banner";
import ListPets from "../components/ListPets";
import SectionReport from "../components/SectionReport";

export const Home = () => {
  return (
    <Layout>
      <Banner />
      <SectionReport />
      <ListPets />
    </Layout>
  );
};
