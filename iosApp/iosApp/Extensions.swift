//
//  Extensions.swift
//  iosApp
//
//  Created by Serhat on 13.11.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation

extension Sequence where Element: Hashable {
    func uniqued() -> [Element] {
        var set = Set<Element>()
        return filter { set.insert($0).inserted }
    }
}
