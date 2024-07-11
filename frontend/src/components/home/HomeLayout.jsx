import React, { useEffect, useNavigate, useState } from "react";
import ImageSlider from "./ImageSlider";
import { mainListDB } from "../../service/homeLogic";


const HomeLayout = () => {
    const navigate = useNavigate()

    // 리스트 담을 변수
    const [marketNew, setMarketNew] = useState([{}])
    const [marketHot, setMarketHot] = useState([{}])
    const [boardNew, setBoardNew] = useState([{}])
    const [boardHot, setBoardHot] = useState([{}])

    useEffect(() => {
        const mainList = async () => {
            const main = {}
            const res = await mainListDB(main)
            console.log(res.data)
            const temp = JSON.stringify(res.data)
            const jsonDoc = JSON.parse(temp)

            //조건용 변수
        }
    })
    return (
        <>
            <ImageSlider />
            <div className="advertise-section">
                <a href={adData.link}>
                    <img src={adData.image} alt="Advertisement" />
                </a>
            </div>

            <div className="curated-section">
                <h2>Curated</h2>
                <div className="curated-posts">
                    {curatedPosts.map(post => (
                        <div key={post.id} className="curated-post">
                            <img src={post.image} alt={post.title} />
                            <h3>{post.title}</h3>
                        </div>
                    ))}
                </div>
            </div>

            <div className="community-section">
                <div className="tabs">
                    {Object.keys(posts).map(tab => (
                        <button
                            key={tab}
                            onClick={() => setActiveTab(tab)}
                            className={activeTab === tab ? 'active' : ''}
                        >
                            {tab}
                        </button>
                    ))}
                </div>
                <div className="posts">
                    {posts[activeTab].map(post => (
                        <div key={post.id} className="post">
                            <h3>{post.title}</h3>
                            <p>{post.content}</p>
                        </div>
                    ))}
                </div>
                <button className="view-more" onClick={() => {/* 해당 카테고리로 이동 */ }}>
                    더보기
                </button>
            </div>
        </>
    )
}

export default HomeLayout;