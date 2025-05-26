import styled from "styled-components";
import NewsItem from "./NewsItem.jsx";
import {useEffect, useState} from "react";
import axios from "axios";

const NewsListBlock = styled.div`
    box-sizing: border-box;
    padding-bottom: 3em;
    width: 768px;
    margin: 2rem auto 0;
    @media screen and (max-width: 768px) {
        width: 100%;
        padding-left: 1em;
        padding-right: 1em;
    }`

const NewsList = (props) => {
    const [articles, setArticles] = useState(null);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            setLoading(true);
            try {
                const query = props.category === 'all' ? '' : `&category=${props.category}`;
                const response = await axios.get(`https://newsapi.org/v2/top-headlines?country=us${query}&apiKey=e65d3b04753840b9871ed1d8d82d1a6d`);
                console.log(response.data.articles);
                setArticles(response.data.articles);
            } catch (e) {
                console.log(e);
            }
            setLoading(false);
        };
        fetchData();
    }, [props.category]);

    if (loading) {
        return <NewsListBlock>대기 중...</NewsListBlock>;
    }
    return (
        <NewsListBlock>
            {articles && articles.map(article => (
                <NewsItem article={article} key={article.url}/>
            ))}
        </NewsListBlock>
    );
}
export default NewsList;