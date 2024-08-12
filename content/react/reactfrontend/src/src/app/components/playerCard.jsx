import Styles from "../Styles/playerCard.module.css";

export default function PlayerCard({ player }) {
    return (
    <div className={Styles.main}>
        <div className={Styles.cardContainer}>
            <div>
                <img className={Styles.image} src={player.imagesrc} alt={player.name} />
                <p className={Styles.name}>{player.name}</p>
                <p className={Styles.team}>{player.team}</p>
            </div>

            <div className={Styles.gridContainer}>
                <div className={Styles.item1}>PPG</div>
                <div className={Styles.item2}>APG</div>
                <div className={Styles.item3}>{player.ppg}</div>
                <div className={Styles.item4}>{player.apg}</div>
                <div className={Styles.item5}> RB</div>
                <div className={Styles.item6}>FG%</div>
                <div className={Styles.item7}>{player.rb}</div>
                <div className={Styles.item8}>{player.fgPercentage}</div>
            </div>
        </div>
    </div>

        
           
    );
}