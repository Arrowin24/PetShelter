package ru.fiksiki.petshelter.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum contains command name.Recommendation for cats info
 */
@Getter
@AllArgsConstructor
public enum RecommendationsDogsCommand {

    DOGS_INTRODUCTION_RULES("1) Начните знакомиться с собакой заранее. Многие приюты приглашают волонтеров для того, чтобы помочь собаке в социализации. Всегда нужны люди, готовые поиграть и погулять с их воспитанниками. Иногда питомцев нужно сфотографировать и разместить эти фото в социальных сетях. Может быть какая-нибудь собака приглянется вам, и вы подружитесь.\n" +
            "\n" +
            "2) Желание взять собаку должно быть общим для всех членов вашей семьи. Если кто-то в семье не любит животных, то лучше помогать информационно или работать волонтером в приюте.\n" +
            "\n" +
            "3) Возьмите понравившуюся собаку на передержку, если с ним будут сложности, то вам будет морально проще вернуть его назад.\n" +
            "\n" +
            "4) Не берите проблемное животное из жалости, если у вас отсутствует опыт взаимоотношений с собаками."),
    LIST_OF_DOCUMENTATIONS_DOGS("Забирая собаку из приюта, вам надо будет подписать договор о передаче животного, а для самой собаки — завести ветпаспорт, куда вписываются проведённые прививки и другая важная информация."),
    TRANSPORTATION_ADVICE_DOGS("Для транспортировки собаки из приюта необходимо иметь при себе переноску для животного нужного размера , убедиться что собака не боиться находиться в переноске , так же внимательно проследить за состоянием собаки во время дороги до дома "),
    HOME_IMPROVEMENT_PUPPIES("Для обустройства дома для щенка необходимо приобрести все нужные атрибуты для животного а именно : лоток для туалета , когтеточку , миска для еды и воды а так же игрушки для вашего будущего питомца и специализированный корм.Так же следует подготовить дом или квартиру к переезду животного"),
    HOME_IMPROVEMENT_DOGS("Для обустройства дома для собаки необходимо приобрести все нужные атрибуты для животного а именно : лоток для туалета , когтеточку , миска для еды и воды а так же игрушки для вашего будущего питомца и специализированный корм.Так же следует подготовить дом или квартиру к переезду животного"),
    HOME_IMPROVEMENT_DISABLED_DOGS("Для обустройства дома для собаки необходимо приобрести все нужные атрибуты для животного а именно : лоток для туалета , когтеточку , миска для еды и воды а так же игрушки для вашего будущего питомца и специализированный корм.Так же следует подготовить дом или квартиру к переезду животного.Все атрибуты для собаки или щенка с ограниченными возможностями должны быть специально подобраны для животного индивидуально"),
    REASONS_FOR_REFUSAL_DOGS("1)Несоответствие требованиям безопасности" + "\n" +
            "2)Адекватность будущего владельца" + "\n" +
            "3)Аллергия" + "\n" +
            "4)Отсутствие собственного жилья" + "\n" + "5)Если вы хотите взять питомца в подарок или ребенку");


    private String recommendationDogsName;

    @Override
    public String toString() {
        return recommendationDogsName ;

    }
}