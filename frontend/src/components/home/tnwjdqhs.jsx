import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import ImageSlider from './ImageSlider';
import { mainListDB } from '../../service/homeLogic';
import { HomeCategories } from './homeData';
import {Main,MainCategoryList,MainSection,MarketList,BoardList, NoneDiv, UserImg} from '../../styles/HomeStyle';
import {AiOutlineRight,BsBookmarkStar,BsBookmarkStarFill,BsFillEyeFill} from 'react-icons/ai';
import { FaHeart } from 'react-icons/fa';

const HomeLayout = () => {
    const navigate = useNavigate();
    const [marketNew, setMarketNew] = useState([]);
    const [marketHot, setMarketHot] = useState([]);
    const [boardNew, setBoardNew] = useState([]);
    const [boardHot, setBoardHot] = useState([]);

    useEffect(() => {
        const fetchMainList = async () => {
            const res = await mainListDB({});
            const temp = JSON.stringify(res.data)
            const jsonDoc = JSON.parse(temp)
            // 데이터 처리 로직...
            // ( free, humor, forum 신규글 / 인기글 ) 조건용 변수
            let freeHotCount = 0;
            let forumHotCount = 0;
            let humorHotCount = 0;
            let freeNewCount = 0;
            let forumNewCount = 0;
            let humorNewCount = 0;
        };
        fetchMainList();
    }, []);

    return (
        <>
            <ImageSlider />
            <Main>
                <MainCategoryList>
                    {HomeCategories.map((item) => (
                        <li key={item.category} onClick={() => navigate('/market/' + item.category)}>
                            <img src={item.img} alt={item.name} />
                            {item.name}
                        </li>
                    ))}
                </MainCategoryList>

                {/* AdvertiseSection */}
                <MainSection>
                    <header>
                        <h2>광고 섹션</h2>
                    </header>
                    {/* 광고 내용 */}
                </MainSection>

                {/* CuratedSection */}
                <MainSection>
                    <header>
                        <h2>큐레이팅된 포스트</h2>
                    </header>
                    {/* 큐레이팅된 포스트 내용 */}
                </MainSection>

                {/* MarketSection - Hot */}
                <MainSection>
                    <header>
                        <h2>지금 뜨는 상품</h2>
                        <Link to="/market/all" className="view-all">
                            전체보기 <AiOutlineRight />
                        </Link>
                    </header>
                    <MarketList>
                        {marketHot.map((post) => (
                            <li key={post.market_no} onClick={() => navigate('/market/detail/' + post.market_no)}>
                                {/* 마켓 아이템 내용 */}
                            </li>
                        ))}
                    </MarketList>
                </MainSection>

                {/* MarketSection - New */}
                <MainSection>
                    <header>
                        <h2>새로 나온 상품</h2>
                        <Link to="/market/all" className="view-all">
                            전체보기 <AiOutlineRight />
                        </Link>
                    </header>
                    <MarketList>
                        {marketNew.map((post) => (
                            <li key={post.market_no} onClick={() => navigate('/market/detail/' + post.market_no)}>
                                {/* 마켓 아이템 내용 */}
                            </li>
                        ))}
                    </MarketList>
                </MainSection>

                {/* CommunitySection - Hot */}
                <MainSection>
                    <header>
                        <h2>커뮤니티 인기글</h2>
                        <Link to="/board/all?page=1" className="view-all">
                            전체보기 <AiOutlineRight />
                        </Link>
                    </header>
                    <BoardList>
                        {boardHot.length > 0 ? boardHot.map((post) => (
                            <li key={post.board_no} onClick={() => navigate('/board/detail/' + post.board_no)}>
                                {/* 게시글 내용 */}
                            </li>
                        )) : (
                            <NoneDiv>인기글이 없습니다.</NoneDiv>
                        )}
                    </BoardList>
                </MainSection>

                {/* CommunitySection - New */}
                <MainSection>
                    <header>
                        <h2>새로 올라온 글</h2>
                        <Link to="/board/all?page=1" className="view-all">
                            전체보기 <AiOutlineRight />
                        </Link>
                    </header>
                    <BoardList>
                        {boardNew.length > 0 ? boardNew.map((post) => (
                            <li key={post.board_no} onClick={() => navigate('/board/detail/' + post.board_no)}>
                                {/* 게시글 내용 */}
                            </li>
                        )) : (
                            <NoneDiv>새로운 글이 없습니다.</NoneDiv>
                        )}
                    </BoardList>
                </MainSection>
            </Main>
        </>
    );
};

export default HomeLayout;