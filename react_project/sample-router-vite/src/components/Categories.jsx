import styled, {css} from "styled-components";
import {NavLink} from "react-router-dom";

const categories = [
    {
        name: 'all',
        text: '전체보기'
    },
    {
        name: 'business',
        text: '비즈니스'
    },
    {
        name: 'entertainment',
        text: '엔터테인먼트'
    },
    {
        name: 'health',
        text: '건강'
    },
    {
        name: 'sport',
        text: '스포츠'
    },
    {
        name: 'technology',
        text: '기술'
    },
];

const CategoryBlock = styled.div`
    display: flex;
    padding: 1rem;
    width: 768px;
    margin: 0 auto;
    @media screen and (max-width: 768px) {
        width: 100%;
        overflow-x: auto;
    }`

const Category = styled(NavLink)`
    font-size: 1.125rem;
    cursor: pointer;
    white-space: pre;
    text-decoration: none;
    padding-bottom: .25rem;
    color: inherit;

    &:hover {
        color: #495057;
    }

    ${props => props.active && css`
        font-weight: 600;
        border-bottom: 2px solid #22bbcf;
        color: #22b8cf;

        &:hover {
            color: #3bc9db;
        }`
    }
    & + & {
        margin-left: 1rem;
    }
`;

const Categories = ({category}) => {
    return (
        <CategoryBlock>
            {categories.map(c => (
                <Category key={c.name} active={c.name === category} to={c.name === 'all' ? '/news' : `/news/${c.name}`}>{c.text}</Category>
            ))}
        </CategoryBlock>
    );
}

export default Categories;