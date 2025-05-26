import Categories from "../components/Categories.jsx";
import NewsList from "../components/NewsList.jsx";
import {useParams} from "react-router-dom";

const News = () => {
    const params = useParams();
    const category = params.category || 'all';
    return (<div>
        <Categories category={category}/>
        <NewsList category={category}/>
    </div>);
}

export default News;